const BASE_URL = "http://localhost:8080/shopping-cart";

async function getShoppingCartById(clientId) {
    const response = await fetch(`${BASE_URL}/${clientId}`, {
        "method": "GET",
    });

    return await response.json();
}

    
async function createShoppingCartById(request,clientId) {
    const getId = {clientId:request}
    const response = await fetch(`${BASE_URL}s`, {
        "method": "POST",
        "body": JSON.stringify(getId),
        "headers": {
            "Content-Type": "application/json",
        },
    });

    return await response.json();
}
//Testing
async function getAllShoppingCarts() {
    const response = await fetch(`${BASE_URL}s`, {
        "method": "GET",
    });

    return await response.json();
}
async function updateShoppingCartById(clientId,request) {
    const response = await fetch(BASE_URL + `/${clientId}`, {
        "method": "PUT",
        "body": JSON.stringify(request),
        "headers": {
            "Content-Type": "application/json",
        },
    });

    return await response.json();
}
async function deleteShoppingCartById(clientId) {
    const response = await fetch(BASE_URL + `/${clientId}`, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json",
        },
    });

    return await response.json();
}

const shopping_cart = {
    getShoppingCartById,
    createShoppingCartById,
    getAllShoppingCarts,
    updateShoppingCartById,
    deleteShoppingCartById
}

export default shopping_cart;