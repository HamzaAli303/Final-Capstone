let form = document.getElementById('form');
let firstname = document.getElementById('firstname-input');
let lastname = document.getElementById('lastname-input');
let email = document.getElementById('email-input');
let employeeContainer = document.getElementById('employeeContainer');
const updateFirstName = document.getElementById("updateFirstName");
const updateArtist = document.getElementById("updateLastName");
const updateEmail = document.getElementById("updateEmail");
const editTable = document.getElementById("editTable");



const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/employees'

const handleSubmit = async (e) => {
    e.preventDefault()

    let bodyObj = {
        firstName: firstname.value,
        lastName: lastname.value,
        email: email.value
    }
    await addEmployee(bodyObj)
 }
async function addEmployee(bodyObj){
  const response = await fetch(`${baseUrl}`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
  })
        .catch(err => console.error(err.message))
        if (response.status == 200){
        return getAllEmployees();
        }
 }

async function getAllEmployees() {
     const response = await fetch(`${baseUrl}/`, {
            method: "GET",
            headers: headers
      })
            .then(response => response.json())
            .then(data => createEmployeeCard(data))
            .catch(err => console.error(err.message))
}

const createEmployeeCard = (array) => {
//    employeeContainer.innerHTML = ''
    let tableData = ""
    array.forEach(obj => {
//    console.log(obj)
//        let employeeCard = document.createElement("div")
//        employeeCard.classList.add("m-2")
        tableData += `


                				<tr>
                					<td>${obj.firstName}</td>
                					<td>${obj.lastName}</td>
                					<td>${obj.email}</td>
                					<td>
                						<button class="btn btn-primary" onclick="editTableDisplay(${obj.id})">Update</button>
                						<button class="btn btn-danger" onclick="deleteEmployeeById(${obj.id})">Delete</button>
                					</td>
                				</tr>


        `

//        employeeContainer.append(employeeCard);

//        tableData +=
//             <tr>
//             <th scope="row">${obj.title}</th>
//             <td scope="row">${obj.artist}</td>
//             <td scope="row">${obj.genre}</td>
//             <td scope="row">${obj.year}</td>
//
//             <td width="174rem">
//             <button class="btn btn-info" onclick="handleDelete(${obj.id})">Update</button>
//             <button class="btn btn-danger" onclick="handleDelete(${obj.id})">Delete</button>
//             </td>
//              </tr>

    document.getElementById("table-body").innerHTML = tableData
    editTableSubmit.innerHTML = `
      <button onclick="updateEmployee(${obj.id})" class="editRowBtn">Update</button><br><br>
      `
    })

}

async function deleteEmployeeById(employeeId){
    console.log(employeeId)
    await fetch(baseUrl + "/" + employeeId, {
        method: "DELETE",
        headers: headers
    })

        .catch(err => console.error(err))

    return getAllEmployees();
}

async function updateEmployee(employeeId){

document.querySelector('.editTable').setAttribute('style', 'display: block;')
console.log(employeeId)
console.log(updateFirstName.value)
    let bodyObj = {
        id: employeeId,
        firstName: updateFirstName.value,
        lastName: updateLastName.value,
        email: updateEmail.value

    }
    console.log(bodyObj)

        const response = await fetch(`${baseUrl}`, {
            method: "PUT",
            body: JSON.stringify(bodyObj),
            headers: headers
        })
            .catch(err => console.error(err.message))
        if (response.status == 200) {
        document.getElementById("updateFirstName").value = "";
        document.getElementById("updateLastName").value = "";
        document.getElementById("updateEmail").value = "";
            return getAllEmployees();
        }
}

function editTableDisplay(id){
    document.querySelector('.editTable').setAttribute('style', 'display: block;')
    document.querySelector('.editTableSubmit').setAttribute('style', 'display: block;')




    return id
}



getAllEmployees();
form.addEventListener("submit", handleSubmit);
