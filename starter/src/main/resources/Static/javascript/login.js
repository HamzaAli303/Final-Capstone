let loginForm = document.getElementById('form')
let loginUsername = document.getElementById('username')
let loginPassword = document.getElementById('password')

const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/users'

const handleSubmit = async (e) =>{
    e.preventDefault()

    let bodyObj = {
        username: loginUsername.value,
        password: loginPassword.value
    }

    const response = await fetch(`${baseUrl}/login`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))

    const responseArr = await response.json()

    if(responseArr[0] === "Username or password incorrect"){
    alert("Username or password incorrect")}
    else if (response.status === 200){
        window.location.replace(responseArr[0])
    }
}

loginForm.addEventListener("submit", handleSubmit)
