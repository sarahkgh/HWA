'use strict';

createRequest = () => {
    fetch(`http://localhost:9000/user/create`, {
        method: 'POST',
        headers:{
            'content-type': "applicationJSON",

        },
        body:JSON.stringify(newUser)
    })
    .then((response) => {
        if(response.status !== 201){
            console.error(`status:${response}`);
            return;
        }
        console.log("Add successful");
    });
};