package bmServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

//import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BmLogin;
import model.Book;
import model.BookLogic;
import model.LoginLogic;
import model.SignUpLogic;
import model.User;


/**
 * Servlet implementation class BmServlet
 */
@WebServlet("/BmServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ログイン画面へフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/SignIn.jsp");
		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getCharacterEncoding();
		
//		System.out.println(response.getCharacterEncoding()); //文字化けしないように
//		response.setCharacterEncoding("UTF-8");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
//		response.setContentType("application/pdf"); //PDFでもできる
		
		System.out.println(response.getCharacterEncoding());				
		PrintWriter out = response.getWriter();
		
		//リクエストパラメータを取得	
		String action =request.getParameter("action");
		
		String id =request.getParameter("id");
		String mail =request.getParameter("mail");
		String pass =request.getParameter("password");
		
		String bookID =request.getParameter("bookID");		
		String title =request.getParameter("title");
		String author =request.getParameter("author");
		String publisher =request.getParameter("publisher");
		String userID =request.getParameter("userID");
		
		//リクエストの種類分け
		
		//アカウント登録処理の実行
		if("SignUp".equals(action)) {
			
			//パラメータチェック あとで（ログイン画面に戻る処理）
			if(mail == null || mail.length() == 0) {
				out.println("メールアドレスを入力してください");
			}
			if(pass == null || pass.length() == 0) {
				out.println("パスワードを入力してください");
			}
			
			BmLogin bmLogin = new BmLogin(mail, pass);
			SignUpLogic sul = new SignUpLogic();
			boolean result = sul.execute(bmLogin);
			
			if(result) {
				//成功・セッションスコープに保存
				HttpSession session = request.getSession();
				session.setAttribute("mail", mail);
				session.setAttribute("pass", pass);
				session.setAttribute("mess", "下記内容でアカウントを登録しました");
				
				//マイページ画面へフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/mypage.jsp");
				dispatcher.forward(request, response);
			}else {
				//失敗・リダイレクト
				response.sendRedirect("/bm/ForwardServlet");
			}			
			
		} else if("SignIn".equals(action))  {
			//ログイン処理
			
			//パラメータチェック あとでやる（ログイン画面に戻る処理）
			if(mail == null || mail.length() == 0) {
				out.println("メールアドレスを入力してください");
			}
			if(pass == null || pass.length() == 0) {
				out.println("パスワードを入力してください");
			}
			
			//ログイン処理の実行
			User bmlogin = new User(mail, pass);
			LoginLogic bo = new LoginLogic();
			bmlogin = bo.execute(bmlogin);
			
			if(bmlogin == null) {
				response.sendRedirect("/bm/ForwardServlet");
			} else {
				
				int uId = bmlogin.getId();
				
				ArrayList<Book> myBooks2 = bo.getBookInfo(uId);//正規出力
//				ArrayList<String> myBooks =  bo.getBookList(id);
//				ArrayList<String> myBooks3 = bo.getBooks(id);
								
				//セッションにアカウント情報を保存
				HttpSession session = request.getSession();
				session.setAttribute("id", uId);
				session.setAttribute("mail", mail);
				session.setAttribute("pass", pass);
				
				//書籍情報
//				session.setAttribute("books", myBooks);//EL式でゴリゴリ書き出し
				session.setAttribute("books2", myBooks2);//正規の出力
//				session.setAttribute("books3", myBooks3);//カンマ区切り
							
				//マイページ画面へフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/mypage.jsp");
				dispatcher.forward(request, response);
				
				}
		}else if ("editUser".equals(action)){
		//ユーザー情報編集画面へ
			
			//JSPから受け取ったIDをintに変換
			int uID = Integer.parseInt(id);
				
			//ユーザー情報を取得
			LoginLogic lo = new LoginLogic();
			User user = lo.getUserInfo(uID);
				
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", user);
				
			//書籍情報編集画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/EditUser.jsp");
			dispatcher.forward(request, response);

			
		}else if ("updateUser".equals(action)){
		//書籍情報を編集し、書籍情報画面へ
					
			//JSPから受け取ったIDをintに変換
			int uID = Integer.parseInt(id);
					
			User user = new User(uID, mail, pass);
			LoginLogic lo = new LoginLogic();
			boolean rs = lo.updateUser(user);
					
			String mess = null;
			if(!rs) {
				mess ="エラーが発生しました";
			} else {
				mess ="ユーザー情報を保存しました";
					
			//マイページの情報を更新
			ArrayList<Book> bookInfo = lo.getBookInfo(uID);
				
			//セッションにデータを保存
			HttpSession session = request.getSession();
			
			session.setAttribute("id", uID);
			session.setAttribute("mail", mail);
			session.setAttribute("pass", pass);
			
			session.setAttribute("books2", bookInfo);
			session.setAttribute("message", mess);
				
			//マイページへフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/mypage.jsp");
			dispatcher.forward(request, response);
					
			}		
			
		} else if ("getBookInfo".equals(action)){
			//書籍情報の詳細を取得
			
			//JSPから受け取ったIDを数字に変換
			int bID = Integer.parseInt(bookID);
			int uID = Integer.parseInt(userID);
			
			//書籍情報一覧を取得
			Book book = new Book(bID, uID);			
			BookLogic bl = new BookLogic();
			book = bl.getBookData(book);
			
			HttpSession session = request.getSession();
			session.setAttribute("BookInfo", book);
			
			//書籍詳細画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/BookInfo.jsp");
			dispatcher.forward(request, response);
			
			
		} else if("deleteBook".equals(action)) {
			//書籍情報を削除
			
			//JSPから受け取ったIDを数字に変換
			int bID = Integer.parseInt(bookID);
			int uID = Integer.parseInt(userID);
			
			//書籍の削除を実行
			Book book = new Book(bID, uID);			
			BookLogic bl = new BookLogic();
			boolean rs = bl.deleteBookData(book);
			
			String mess = null;
			if(rs) {
				mess = "削除が完了しました";
			}else if(!rs) {
				mess = "エラーが発生しました";
			}			
			//マイページの情報を更新
			LoginLogic bo = new LoginLogic();
			User userInfo = bo.getUserInfo(uID);				
			ArrayList<Book> bookInfo = bo.getBookInfo(uID);
			
			//セッションにデータを保存
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", userInfo);
			session.setAttribute("books2", bookInfo);
			session.setAttribute("message", mess);
			
			//マイページへフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/mypage.jsp");
			dispatcher.forward(request, response);
			
			
		}else if ("editBookInfo".equals(action)){
				//書籍情報を取得し、編集画面へ
				
				//JSPから受け取ったIDを数字に変換
				int bID = Integer.parseInt(bookID);
				int uID = Integer.parseInt(userID);
				
				//書籍情報一覧を取得
				Book book = new Book(bID, uID);			
				BookLogic bl = new BookLogic();
				book = bl.getBookData(book);
				
				HttpSession session = request.getSession();
				session.setAttribute("BookInfo", book);
				
				//書籍情報編集画面へフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/EditBook.jsp");
				dispatcher.forward(request, response);
				
		}else if ("updateBook".equals(action)){
			//書籍情報を編集し、書籍情報画面へ
			
			//JSPから受け取ったIDを数字に変換
			int bID = Integer.parseInt(bookID);
			int uID = Integer.parseInt(userID);
			
			Book nbook = new Book(bID, title, author, publisher, uID);
			BookLogic blo = new BookLogic();
			boolean rs = blo.updateBook(nbook);
			
			String mess = null;
			if(!rs) {
				mess ="エラーが発生しました";
			} else {
				mess ="書籍情報を保存しました";
			
			//書籍情報一覧を取得
			Book book = new Book(bID, uID);			
			BookLogic bl = new BookLogic();
			book = bl.getBookData(book);
			
			HttpSession session = request.getSession();
			session.setAttribute("BookInfo", book);
			session.setAttribute("message", mess);
			
			//書籍情報編集画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/BookInfo.jsp");
			dispatcher.forward(request, response);
			}
			
		}else if ("AddBook".equals(action)){
			//書籍追加画面へ
			
			//JSPから受け取ったIDを数字に変換
			int uID = Integer.parseInt(userID);
			
			//書籍情報一覧を取得
			User user = new User(uID);			
			
			HttpSession session = request.getSession();
			session.setAttribute("userID", user);
			
			//書籍情報編集画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/AddBook.jsp");
			dispatcher.forward(request, response);
		
		}else if ("addNewBook".equals(action)){
			//書籍情報を編集し、書籍情報画面へ
			
			//JSPから受け取ったIDを数字に変換
			int uID = Integer.parseInt(userID);
			
			Book nbook = new Book(title, author, publisher, uID);
			BookLogic blo = new BookLogic();
			boolean rs = blo.addBook(nbook);
			
			String mess = null;
			if(!rs) {
				mess ="エラーが発生しました";
			} else {
				mess ="書籍情報を保存しました";


			//マイページの情報を更新
			LoginLogic bo = new LoginLogic();
			User userInfo = bo.getUserInfo(uID);				
			ArrayList<Book> bookInfo = bo.getBookInfo(uID);
			
			//セッションにデータを保存
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", userInfo);
			session.setAttribute("books2", bookInfo);
			session.setAttribute("message", mess);
			
			//マイページへフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/mypage.jsp");
			dispatcher.forward(request, response);
			
			}
		}	
	}
}
		
