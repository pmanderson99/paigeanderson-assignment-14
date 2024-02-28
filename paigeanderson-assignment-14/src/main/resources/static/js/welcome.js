function setUsername() {
	const usernameInput = document.getElementById('username');
	const username = usernameInput.value;

	if (username.trim() !== '') {
		sessionStorage.setItem('username', username);
		window.location.href = '/channels'
	}
}


function promptForUsername() {
	var username = sessionStorage.getItem('username');

	if (username == null || username.trim() === '') {
		username = prompt('enter your username');

		if (username == null || username.trim() === '') {
			promptForUsername();
		} else {
			sessionStorage.setItem('username', username);
		}
	}
}
promptForUsername();

