function setUsername() {
	const  usernameInput = document.getElementById('username');
	const username = usernameInput.value;
	
	if(username.trim() !== ''){
		sessionStorage.setItem('username', username);
		window.location.href = '/channels'
	}
}