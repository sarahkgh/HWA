'use strict';


createRequest = () => {

let inputCreateUserFirst = document.querySelector('#inputCreateUserFirst');
let inputCreateUserName = document.querySelector('#inputCreateUserName');
let createUserbtn = document.querySelector('#createUserbtn');

createUserbtn.addEventListener('click', () => {
    let inputCreateUserFirst = inputCreateUserFirst;
let inputCreateUserName = inputCreateUserName;

inputCreateUserFirst.value = "";
inputCreateUserName.value = "";
let newUser = {
    firstName: `${createUserFirst}`,
    userName: `${createUserName}`
}
postRequest(newUser);

})

let postRequest = (newUser) => {

    fetch(`http://localhost:9000/user/create`, {
        method: 'POST',
        headers:{
            'content-type': "applicationJSON",

        },
        body:JSON.stringify(newUser)
    })
    .then((response) => {

        console.log(response);
        return response.json();
    })

        if(response.status !== 201){
            console.error(`status:${response}`);
            return;
        }
        console.log("Add successful");
    });
};

    }


