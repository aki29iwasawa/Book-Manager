function SignInCheck(){
	//要素取得　formの中のmail,passの前に入れたい
	var form = document.getElementById('form');
	
	var mail = document.getElementById('mail');	
	var pass = document.getElementById('password');
	
	//<p>を作成
	var mailMess = document.createElement('p');
	mailMess.textContent = 'メールアドレスを入力してください';
	
	var passMess = document.createElement('p');
	passMess.textContent = 'パスワードを入力してください';

	if ((form.mail.value == "")||(form.password.value == "")){
		alert("未入力項目があります");
		
		if(form.mail.value == ""){
	    //メールアドレスが空の場合
	    	form.insertBefore(mailMess, mail);
		}if(form.password.value == ""){
		//パスワードが空の場合
	    	form.insertBefore(passMess, pass);
	    }
	    return false;	    
    }else{
    //条件に一致しない場合(メールアドレスが入力されている場合)
        return true;
    	}
    }
    
    
