let user = sessionStorage.getItem('user')

function setUsername() {
	
	const username = document.getElementById('username');

	if (username.trim() !== '') {
		sessionStorage.setItem('username', username);
		window.location.href = '/channels'
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
