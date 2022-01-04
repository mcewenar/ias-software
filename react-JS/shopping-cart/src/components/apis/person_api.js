const BASE_URL = "http://localhost:8080";
const personUrl = 'person';
const personsUrl = 'persons';

//Other way for making request api (async function listPersons()). The first one dont have Hoisting property
const getAllPersons = async () => {
    //Other way is using Axios library, instead of fetch
    const response = await fetch(`/${BASE_URL}/${personsUrl}`, {
        method: "GET",
    });

    return await response.json();

}
const getPersonsById = async (personId) => {
    const response = await fetch(`${BASE_URL}/${personUrl}/${personId}`, {
      "method": "GET",
      "headers": {
        "Accept": 'application/json',
        "Content-Type": 'application/json'
      }
    });
    //Bring the Json. 
    return await response.json();
  }
  
const createPersons = async (response) => {
  const response = await fetch(`${BASE_URL}/${personsUrl}`, {
      "method": "POST",
      "body": JSON.stringify(request),
      "headers": {
          "Content-Type": "application/json",
      },
  });

  return await response.json();
}

const deletePersonsById = async (personId) => {
  const response = await fetch(`${BASE_URL}/${personUrl}/${personId}`, {
    "method": "DELETE",
    "headers": {
          "Content-Type": "application/json",
      },
  });

  return await response.json();
}

const updatePersonsById = async (request,personId) => {
  const response = await fetch(`${BASE_URL}/${personUrl}/${personId}`, {
    "method": "PUT",
    "body": JSON.stringify(request),
    "headers": {
          "Content-Type": "application/json",
      },
  });

  return await response.json();
}


const person = {
    getAllPersons,
    getPersonsById,
    createPersons,
    deletePersonsById,
    updatePersonsById
};

  



export default person;

