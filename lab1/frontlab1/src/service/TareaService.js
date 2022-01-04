import axios from 'axios';

export default class TareaService{

    url="http://localhost:8090/" 

    getOneTarea(id){
        return axios.get(this.url +"tareas/" + id);
    }

    getAllTareas(){
        return axios.get(this.url + "tareas");
    }

    getVoluntarioTarea(id){
        return axios.get(this.url + "tareas/voluntario/" + id);
    }

    deleteTarea(id){
        return axios.get(this.url + "tareas/delete/" + id);
    }
}