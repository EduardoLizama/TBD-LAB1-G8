import axios from 'axios';

export default class RankingService{

    url="http://localhost:8090/" 

    completeVolTarea(id_Vol, id_tar){
        return axios.get(this.url +"ranking/completeTarea/" + id_Vol + "/" + id_tar);
    }
    cancelRanking(id_Vol, id_tar){
        return axios.get(this.url + "ranking/cancel/" + id_Vol + "/" + id_tar)
    }
}