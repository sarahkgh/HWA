'use strict';

createRequest = () => {
    fetch(`http://localhost:9000/course/create`, {
        method: 'POST',
        headers:{
            'content-type': "applicationJSON",

        },
        body:JSON.stringify(newCourse)
    })
    .then((response) => {
        if(response.status !== 201){
            console.error(`status:${response}`);
            return;
        }
        console.log("Add successful");
    });
};