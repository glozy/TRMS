

function getForms() {
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {
			let forms = xhr.responseText;
			console.log(forms);
			document.getElementById("form-list").innerHTML = forms;
		}
	}
	
	xhr.open("GET", "/TRMS/update", true);
	
	xhr.send();
	
}

function getFormById() {
	let formName = document.getElementById("form-id-input").value;
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {
			let form = JSON.parse(xhr.responseText);
			//let form = (xhr.responseText);
			console.log(form);
			displayForm(form);
		}
	}
	
	xhr.open("GET", "/TRMS/update/" + formName, true);
	
	xhr.send();
}

function displayForm (form) {
	let formString = "<b><i>FormId:</i></b> " + form.formId + "<br>" +
	"<b><i>EmployeeId:</i></b> " + form.employeeID + "<br>" +
	"<b><i>Start Date:</i></b> " + form.startDate + "<br>" +
    "<b><i>End Date:</i></b> " + form.endDate + "<br>" +
    "<b><i>Address Location:</i></b> " + form.address + "<br>" +
	"<b><i>Events:</i></b> " + form.events + "<br>" +
	"<b><i>Description:</i></b> " + form.description+"<br>" +
    "<b><i>Status:</i></b> " + form.status + "<br>" +
	"<b><i>Course Cost:</i></b> " + form.course_cost + "<br>" +
    "<b><i>Grading Format:</i></b> " + form.grading_format + "<br>" +
    "<b><i>form time:</i></b> " + form.form_time

	document.getElementById("my-form").innerHTML = formString;
}



let Form = function(formId, employeeID, 
		startDate, endDate, address, events, description,
    work_justify, status, course_cost, grading_format, form_time,grade) {
            this.formId = formId;
            this.employeeID = employeeID;
            this.startDate = startDate;
            this.endDate = endDate;
            this.form_time = form_time;
            this.address_location = address;
            this.description = description;
            this.course_cost = course_cost;
            this.status = status;
            this.grading_format = grading_format;
            this.events = events;
            this.work_justify = work_justify;
            this.grade = grade;

    }


window.onload = function () {
	
	getForms();
	document.getElementById("get-form").addEventListener("click", getFormById);
}