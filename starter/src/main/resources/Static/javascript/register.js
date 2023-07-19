
const registerForm = document.getElementById('form')
const registerUsername = document.getElementById('username')
const registerPassword = document.getElementById('password')

const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/users'


const handleSubmit = async (e) =>{
    e.preventDefault()

    let bodyObj = {
        username: username.value,
        password: password.value
    }
    console.log(bodyObj)
    const response = await fetch(`${baseUrl}/register`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))

    const responseArr = await response.json()

    if (response.status === 200){
        window.location.replace(responseArr[0])
    }
}

registerForm.addEventListener("submit", handleSubmit)