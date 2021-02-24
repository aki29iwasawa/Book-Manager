package bmServlet;

import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import model.BookLogic;
//import model.Book;
//import model.BookLogic;
import model.LoginLogic;
//import model.Memo;
//import model.MemoLogic;
//import model.SignUpLogic;
//import model.User;
import model.MemoLogic;


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

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ForwardBm.jsp");
		dispatcher.forward(request, response);
		
		
//		//ログイン画面へフォワード
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/SignIn.jsp");
//		dispatcher.forward(request, response);
		
		
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
//		PrintWriter out = response.getWriter();
		
		//リクエストパラメータを取得	
		String action =request.getParameter("action");		
		String id =request.getParameter("id");
		
//		String mail =request.getParameter("mail");
//		String pass =request.getParameter("password");
//		
//		String bookID =request.getParameter("bookID");		
////		String title =request.getParameter("title");
////		String author =request.getParameter("author");
////		String publisher =request.getParameter("publisher");
		String userID =request.getParameter("userID");
//		
//		String pageNum =request.getParameter("pageNum");
//		String direction =request.getParameter("direction");
//		
//		
		//リクエストの種類分け

		if("SignUp".equals(action)) {
		//アカウント登録
			
////パラメータチェックを別で作る			
//			//パラメータチェック あとで（ログイン画面に戻る処理）
//			if(mail == null || mail.length() == 0) {
//				out.println("メールアドレスを入力してください");
//			}
//			if(pass == null || pass.length() == 0) {
//				out.println("パスワードを入力してください");
//			}

			LoginLogic lo = new LoginLogic(request);
			boolean result = lo.createAccount(request);
			
			if(result) {
				//マイページへ
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/mypage.jsp");
				dispatcher.forward(request, response);
			}else {
				//失敗・リダイレクト
				response.sendRedirect("/bm/Forwardbm.jsp");
			}			
			
		} else if("SignIn".equals(action))  {
		//ログイン処理
			
			LoginLogic lo = new LoginLogic(request);
			lo.Login(request);
			
			//マイページへ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/mypage.jsp");
			dispatcher.forward(request, response);
			
		} else if("logOut".equals(action))  {
		//ログアウト処理
			
			//ログアウトのセッションに関して質問する
//			HttpSession session = request.getSession();
//			session.invalidate();
		
			//トップページへ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ForwardBm.jsp");
			dispatcher.forward(request, response);

		}else if("toMypage".equals(action))  {
		//マイページへ画面遷移
			
			//JSPから受け取ったIDをintに変換
			//ログインと同じメソッドを使いたいのでここでint変換
			int uID = Integer.parseInt(id);			
			LoginLogic lo = new LoginLogic(request);
			lo.toMypage(request, uID);

			//マイページへ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/mypage.jsp");
			dispatcher.forward(request, response);
	
		}else if ("toEditUserPage".equals(action)){
		//ユーザー情報編集画面へ
			
			LoginLogic lo = new LoginLogic(request);
			lo.getUserInfo(request);
				
			//書籍情報編集画面へ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/EditUser.jsp");
			dispatcher.forward(request, response);
			
		}else if ("updateUser".equals(action)){
		//ユーザー情報を更新し、マイページへ
			
			LoginLogic lo = new LoginLogic(request);
			lo.updateUser(request);
			
			//マイページへ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/mypage.jsp");
			dispatcher.forward(request, response);
						
			
		} else if("deleteUser".equals(action)) {
		//アカウント情報を削除
			
			LoginLogic lo = new LoginLogic(request);
			lo.deleteUser(request);

			//トップページへ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ForwardBm.jsp");
			dispatcher.forward(request, response);
		

		} else if ("getBookInfo".equals(action)){
		//書籍の詳細を取得（一冊）し、書籍表示画面へ

			BookLogic bo = new BookLogic(request);
			bo.getBookInfo(request);
			
			//書籍表示画面へ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/BookInfo.jsp");
			dispatcher.forward(request, response);	
		
			
		} else if ("editBook".equals(action)){
		//書籍の詳細を取得し、情報編集画面へ

			BookLogic bo = new BookLogic(request);
			bo.getBookInfo(request);
			
			//書籍情報編集画面へ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/EditBook.jsp");
			dispatcher.forward(request, response);	

			
		}else if ("updateBook".equals(action)){
		//書籍情報を更新し、書籍表示画面へ
		
			BookLogic bo = new BookLogic(request);
			bo.updateBook(request);
		
			//書籍表示画面へ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/BookInfo.jsp");
			dispatcher.forward(request, response);
		
		
		} else if("deleteBook".equals(action)) {
		//書籍情報を削除
			
			BookLogic bo = new BookLogic(request);
			bo.deleteBookData(request);
	
			//マイページへ
			//JSPから受け取ったIDをintに変換
			//ログインと同じメソッドを使いたいのでここでint変換
			int uID = Integer.parseInt(userID);			
			LoginLogic lo = new LoginLogic(request);
			lo.toMypage(request, uID);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/mypage.jsp");
			dispatcher.forward(request, response);		
			
			
		}else if ("addBook".equals(action)){
		//書籍追加画面へ
			
			request.setAttribute("uID", id);
			
			//書籍情報編集画面へ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/AddBook.jsp");
			dispatcher.forward(request, response);
		
			
		}else if ("addNewBook".equals(action)){
		//書籍を追加し、書籍表示画面へ
			
			BookLogic bo = new BookLogic(request);
			bo.addBook(request);
			
			//マイページへ
			//JSPから受け取ったIDをintに変換
			//ログインと同じメソッドを使いたいのでここでint変換
			int uID = Integer.parseInt(userID);			
			LoginLogic lo = new LoginLogic(request);
			lo.toMypage(request, uID);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/mypage.jsp");
			dispatcher.forward(request, response);
			
			
		} else if("bookList".equals(action)) {
		//書籍リストと検索の画面へ.
			
			BookLogic bo= new BookLogic(request);
			bo.BookList(request);
			
			//リスト・検索画面へ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/BookList.jsp");
			dispatcher.forward(request, response);	


		} else if("getPaged".equals(action)) {
		//書籍リストのページング

			BookLogic bo= new BookLogic(request);
			bo.getPaged(request);

			//新規ページ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/BookList.jsp");
			dispatcher.forward(request, response);

			
		}else if ("memoList".equals(action)){
		//アカウントメモを取得し、メモ編集画面へ

			MemoLogic ml= new MemoLogic(request);
			ml.MemoList(request);
			
			//書籍情報編集画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/MemoList.jsp");
			dispatcher.forward(request, response);
			
		}	
	}
}
		
