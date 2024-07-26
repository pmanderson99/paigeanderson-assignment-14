let user = sessionStorage.getItem('user')

if (user === null) {

	let username = prompt('Welcome, enter your name', 'Guest')
	while (username === null || username === '') {
		username = prompt('username required', 'Guest')
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