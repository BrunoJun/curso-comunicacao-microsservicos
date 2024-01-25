import axios from "axios";
import {PRODUCT_API_URL} from '../../../config/constants/secrets.js';

class ProductClient{

    async checkProductStock(productsData, token, transactionid){

        try {
            
            const headers = {Authorization: token, transactionid}

            console.info(`Sending request to Product API with data: ${JSON.stringify(productsData)} and TransactionId: ${transactionid}`);

            let response = false;

            await axios.post(`${PRODUCT_API_URL}/check-stock`, {products: productsData.products}, {headers})
            .then((res) => {

                console.info(`Success response from Product API. TransactionId: ${transactionid}`);
                response = true;
            })
            .catch((error) => {

                console.error(`Error response from Product API. TransactionId: ${transactionid}`);
                response = false;console.error(error.message)
            });

            return response;
        } catch (error) {
            
            console.error(`Error response from Product API. TransactionId: ${transactionid}`);
            return false;
        }
    }
}

export default new ProductClient();