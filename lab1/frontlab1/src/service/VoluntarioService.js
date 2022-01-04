import axios from 'axios';

export default class VoluntarioService{

    url="http://localhost:8090/" 

    getOneVoluntario(id){
        return axios.get(this.url +"voluntarios/mostrar/" + id);
    }

    getAllVoluntarios(){
        return axios.get(this.url + "voluntarios");
    }
    deleteVoluntario(id){
        return axios.delete(this.url + "voluntarios/delete/"+ id);
    }
}