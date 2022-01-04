const BASE_URL = "http://localhost:8080";
const productUrl = 'product';
const productsUrl = 'products';

//Other way for making request api (async function listPersons()). The first one dont have Hoisting property
const getAllProducts = async () => {
    //Other way is using Axios library, instead of fetch
    const response = await fetch(`/${BASE_URL}/${productsUrl}`, {
        method: "GET",
    });

    return await response.json();

}
const getProductById = async (productId) => {
    const response = await fetch(`${BASE_URL}/${productUrl}/${productId}`, {
      "method": "GET",
      "headers": {
        "Accept": 'application/json',
        "Content-Type": 'application/json'
      }
    });
    //Bring the Json. 
    return await response.json();
  }
  
const createProduct = async (request) => {
  const response = await fetch(`${BASE_URL}/${productsUrl}`, {
      "method": "POST",
      "body": JSON.stringify(request),
      "headers": {
          "Content-Type": "application/json",
      },
  });

  return await response.json();
}

const deleteProductById = async (productId) => {
  const response = await fetch(`${BASE_URL}/${productUrl}/${productId}`, {
    "method": "DELETE",
    "headers": {
          "Content-Type": "application/json",
      },
  });

  return await response.json();
}

const updateProductById = async (request,productId) => {
  const response = await fetch(`${BASE_URL}/${productUrl}/${productId}`, {
    "method": "PUT",
    "body": JSON.stringify(request),
    "headers": {
          "Content-Type": "application/json",
      },
  });

  return await response.json();
}


const productsApi = {
    getAllProducts,
    getProductById,
    createProduct,
    deleteProductById,
    updateProductById
};

  
export default product;

