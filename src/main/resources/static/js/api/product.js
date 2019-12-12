import { apiUrl } from "./config";
import axios from "axios";

export default {
   productItem: {
        resourceUrl: "product",
        getAll() {
            return axios({
                url: `${apiUrl}/${this.resourceUrl}`,
                method: "GET"
            });
        },
        getOne(id) {
            return axios({
                url: `${apiUrl}/${this.resourceUrl}/${id}`,
                method: "GET"
            });
        },
        add(item) {
            return axios({
                url: `${apiUrl}/${this.resourceUrl}`,
                method: "POST",
                data: item
            });
        },
        edit(id, item) {
            return axios({
                url: `${apiUrl}/${this.resourceUrl}/${id}`,
                method: "PUT",
                data: item
            });
        },
        delete(id) {
            return axios({
                url: `${apiUrl}/${this.resourceUrl}/${id}`,
                method: "DELETE"
            });
        }
    }
};