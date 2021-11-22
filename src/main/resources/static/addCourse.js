'use strict';


createRequest = () => {

let inputCreateCourseName = document.querySelector('#inputCreateCourseName');
let inputCreateCourseDesc = document.querySelector('#inputCreateCourseDesc');
let createCoursebtn = document.querySelector('#createCoursebtn');

createCoursebtn.addEventListener('click', () => {
    let inputCreateCourseName = inputCreateCourseName;
let inputCreateCourseDesc = inputCreateCourseDesc;

inputCreateCourseName.value = "";
inputCreateCourseDesc.value = "";
let newCourse = {
    courseName: `${createCourseName}`,
    courseDescription: `${createCourseDescription}`
}
postRequest(newCourse);

})

let postRequest = (newCourse) => {

    fetch(`http://localhost:9000/course/create`, {
        method: 'POST',
        headers:{
            'content-type': "applicationJSON",

        },
        body:JSON.stringify(newCourse)
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


