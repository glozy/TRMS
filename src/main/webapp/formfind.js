/**
 * 
 */

function getForms() {
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {
			let forms = xhr.responseText;
			console.log(forms);
			document.getElementById("form-list").innerHTML = forms;
		}
	}
	
	xhr.open("GET", "/TRMS/approve", true);
	
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
	
	xhr.open("GET", "/TRMS/approve/" + formName, true);
	
	xhr.send();
}

function displayForm (form) {
	let formString = "FormId: " + form.formId + "<br>" +
		"EmployeeId: " + form.employeeID + "<br>" +
		"Start Date: " + form.startDate + "<br>" +
        "End Date: " + form.endDate + "<br>" +
        "Address Location: " + form.address + "<br>" +
		"Events: " + form.events + "<br>" +
		"Description: " + form.description+"<br>" +
        "Work Justify: " + form.work_justify + "<br>" +
        "Status: " + form.status + "<br>" +
		"Course Cost: " + form.course_cost + "<br>" +
        "Grading Format: " + form.grading_format + "<br>" +
        "form time" + form.form_time

	document.getElementById("my-form").innerHTML = formString;
}



let Form = function(formId, employeeID, 
		startDate, endDate, address, events, description,
	    work_justify, status, course_cost, grading_format, form_time  ) {
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

    }


window.onload = function () {
	
	getForms();
	 document.getElementById("get-form").addEventListener("click", getFormById);
	// document.getElementById("updatestatus").addEventListener("click", postAnimal);
}