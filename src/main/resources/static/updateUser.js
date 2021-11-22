'use strict';


updateRequest = (userId) =>{
    fetch(`http://localhost:9000/user/update`, {
        method: 'PATCH',
    })
    .then((response) => {
        if(response.status !== 203){
            console.error(`status:${response}`);
            return;
        }
        response.json()
        .then((data)=>{
            console.log(data);
        })

let inputUpdateUserFirst = document.querySelector('#inputUpdateUserFirst');
let inputUpdateUserName = document.querySelector('#inputUpdateUserName');
let updateUserbtn = document.querySelector('#updateUserbtn');

let inputUpdateUserId = document.querySelector('#inputUpdateUserId');

let updateUser = (userId) =>{
    let user = {
        "firstName": inputUpdateFirst.value,
        "userName": inputUpdateUserName.value
    };
 fetch(`http://localhost:9000/user/update/${userId}`, {
        method: 'PUT',
        headers: {
            "Content-type":"application/json"
        },
        body: JSON.stringify(user)
    })
    .then((response) => {
        
        response.json();
    })
        .then(()=>{
            

        console.log("Update succesful");
    });
};


let updateButton = document.querySelector('#updateButton');
let updateName = document.querySelector('#updateName');
let updateUName = document.querySelector('#updateUName');

let updateFunction = () => {
    let findTextValue = indText.ariaValueMax;
    let courseName = findTextValue;
    updateRequest(firstName, userName);
}

updateButton.addEventListener('click', updateFunction);

let updateUserbtn = document.querySelector('#updateUserbtn');
let updateUserFirst = document.querySelector('#updateUserFirst');
let updateUserName = document.querySelector('#updateUserName');

let updateFunction = () => {
    let findTextValue = indText.ariaValueMax;
    let updateUserFirst = findTextValue;
    updateRequest(firstName, userName);
}

updateUserBtn.addEventListener('click', updateFunction);

