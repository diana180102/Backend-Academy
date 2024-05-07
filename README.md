                     
<h1 align="center" style="font-weight: bold;">BACKEND(SERVICIO REST) - REGISTRO DE ESTUDIANTES A CURSOS💻</h1>

<p align="center">
<a href="#tech">Technologies</a>
<a href="#started">Getting Started</a>
<a href="#routes">API Endpoints</a>

 
</p>


<p align="center">Proyecto para llevar el control de registros de matrícula de los estudiantes de una academia.
Se debe tener almacenado los datos de estudiantes, cursos y registro de los estudiantes matriculados en cada curso.




</p>
<p align="center">
Project to manage student enrollment records at an academy. We need to store data of students and courses, and manage student enrollment in each course


</p>


 
<h2 id="technologies">💻 Technologies</h2>


- LOMBOOK

|  Tecnology              | Description                                          
|----------------------  |-----------------------------------------------------
|  [![My Skills](https://skillicons.dev/icons?i=java)](https://skillicons.dev)    | JAVA 17
| [![My Skills](https://skillicons.dev/icons?i=spring)](https://skillicons.dev)      |  SPRING BOOT 3
| [![My Skills](https://skillicons.dev/icons?i=maven)](https://skillicons.dev)      |  MAVEN
| [![My Skills](https://skillicons.dev/icons?i=postgresql)](https://skillicons.dev)      |  POSTGRESQL

 
<h2 id="started">🚀 Getting started</h2>

You need to clone the repository and install spring boot
 
<h3>Cloning</h3>

How to clone your project

```bash
gh repo clone diana180102/Backend-Academy
```
 
<h2 id="routes">📍 API Endpoints</h2>

You can use http://localhost:{port}/{path} for GET or POST requests to test locally

<h2 id="post-auth-detail"> STUDENTS </h2> 


​
| route               | description                                          
|----------------------|-----------------------------------------------------
| <kbd>GET /students</kbd>     | retrieves course info see 
| <kbd>POST /students</kbd>      |  save course of students


<h3 id="get-auth-detail">GET /students</h3>

**RESPONSE**
```json
{
	"status": 200,
	"message": "success",
	"data": [
		{
			"idStudent": 2,
			"name": "Natalia",
			"surname": "Usuga",
			"age": 36,
			"DNI": "5225515"
		}
        ]
  }

```

<h3 id="post-auth-detail">POST /students</h3>

**REQUEST**
```json
{
	"name": "Garfield",
	"surname": "Usuga",
	"DNI": "8745646",
	"age": 40
}

```

<h2 id="post-auth-detail">COURSE </h2>

route               | description                                          
|----------------------|-----------------------------------------------------
| <kbd>GET /courses</kbd>     | retrieves course info see 
| <kbd>POST /courses</kbd>      |  save info course

<h3 id="get-auth-detail">GET /course</h3>

**RESPONSE**
```json
{
	"status": 200,
	"message": "success",
	"data": [
		{
			"idCourse": 1,
			"name": "Calculo 1",
			"acronym": "calc",
			"state": true
		}
        ]
}

```

<h3 id="post-auth-detail">POST /course</h3>

**REQUEST**
```json
{
	"idCourse": 3,
	"name": "Excel Básico",
	"acronym": "ExcelB",
	"state": true
}

```

<h2 id="post-auth-detail">REGISTER </h2>

route               | description                                          
|----------------------|-----------------------------------------------------
| <kbd>GET /register</kbd>     | retrieves register info see 
| <kbd>POST /register</kbd>      |  save register of students

<h3 id="get-auth-detail">GET /course</h3>

**RESPONSE**
```json
{
	"status": 200,
	"message": "success",
	"data": [
			{
			"idRegister": 2,
			"datetime": "2024-04-28T20:19:35",
			"student": {
				"idStudent": 2,
				"name": "Natalia",
				"surname": "Usuga",
				"age": 36,
				"DNI": "5225515"
			},
			"state": true,
			"registerDetails": [
				{
					"idDetails": 2,
					"classroom": "201A",
					"course": {
						"idCourse": 1,
						"name": "Calculo 1",
						"acronym": "calc",
						"state": true
					}
				}
			]
		}
        ]
}

```

<h3 id="post-auth-detail">POST /course</h3>

**REQUEST**
```json
{
	"datetime": "2024-04-28T20:19:35",
	"student" : { "idStudent" : 6},
	"state": true,
	"registerDetails": [
		 {
			 "course":  {"idCourse" : 3},
			 "classroom": "501A"
			 
		 }
	]
	
}
```

<h3> Get the count of students for each course  </h3>

<h5> ROUTE </h5>
<p> /registers/courseCount </p>


<h3> Get name of students registered in a course specific  </h3>

<h5> ROUTE </h5>
<p> /registers/courseStudent</p>

<h3> Order students  </h3>

<h5> ROUTE </h5>
<p> /student/order</p>








