// need to figure out why new users are generated everytime you go back to the welcome page

/*function setUsername() {
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
promptForUsername();*/

let user = sessionStorage.getItem('user')

if (user === null) {

	let username = prompt('Welcome, Enter Your Name')
	while (username === null || username === '') {
		username = prompt('Username Required')
	}

	fetch(`/welcome/createUser`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: username
	})
		.then(response => response.json())
		.then(user => {
			console.log(user)
			sessionStorage.setItem('username', JSON.stringify(user))
		})

} else {
	user = JSON.parse(sessionStorage.getItem('username'));
}