<template>  
    <div>
    <Toast />
    <Panel>
        <Datatable :value="voluntario1">
            <Column field="nombre_voluntario" header="Mi perfil"></Column>
        </Datatable>
        <Menubar :model="items" />
            <Datatable :value="tareasVoluntario" :paginator="true" :rows="7" selectionMode="single" :selection.sync="selectedVoluntario" dataKey="id_voluntario">
                <Column field="id_tarea" header="ID Tarea"></Column>
                <Column field="nombre_tarea" header="Nombre tarea"></Column>
                <Column field="capacidad" header="Voluntarios asignados"></Column>
                <Column field="id_emergencia" header="ID emergencia"></Column>
            </Datatable>
        </Panel>
    </div>
</template>

<script>
import VoluntarioService from'../service/VoluntarioService';
import TareaService from '../service/TareaService';
import RankingService from '../service/RankingService';

export default{
    name : 'CrudApp',
    data(){
        return{
            voluntarios : null,
            tareasVoluntario : null,
            mensaje_1 : null,
            voluntario1 : [],
            selectedVoluntario:{
                voluntarios : null,
            },
            items:[
                {
                    label: 'Refrescar',
                    icon: 'pi pi-fw pi-refresh',
                    command: () =>{
                        this.getAll();
                    }
                },
                {
                    label : 'Completar',
                    icon : 'pi pi-fw pi-pencil',
                    command: () =>{
                        this.completeTarea();
                    }
                },
                {
                   label : 'Eliminar',
                   icon : 'pi pi-fw pi-trash',
                   command: () =>{
                        this.deleteTarea();
                    }
               }
            ]
       }
    },
    voluntarioService : null,
    tareaService : null,
    rankingService : null,
    created(){
        this.voluntarioService = new VoluntarioService();
        this.tareaService = new TareaService();
        this.rankingService = new RankingService();
        document.title = "Tareas asignadas";
    },
    mounted(){
        this.voluntarioService.getOneVoluntario(1).then(data => {
            this.mensaje_1 = data.data;
            this.voluntario1.push(this.mensaje_1);
        });
        this.tareaService.getVoluntarioTarea(1).then(data => this.tareasVoluntario = data.data);
        
    },
    methods : {
        deleteTarea(){
            if(confirm("¿Esta seguro que desea eliminar el registro?")){
                this.rankingService.cancelRanking(this.mensaje_1.id_voluntario, this.selectedVoluntario.id_tarea).then(data => {
                    if(data.status === 200){
                        alert("¡La tarea ha sido cancelada con exito!");
                        this.getAll();
                    }
                });
            }
        },
        completeTarea(){
            if(confirm("¿Está seguro que desea completar la tarea?")){
                this.rankingService.completeVolTarea(this.mensaje_1.id_voluntario, this.selectedVoluntario.id_tarea).then(data =>{
                    if(data.status === 200){
                        alert("¡La tarea ha sido completada con exito!");
                        //this.rankingService.updateRanking()
                        this.getAll();
                    }
                })
            }
        },
        getAll(){
            this.tareaService.getVoluntarioTarea(1).then(data => this.tareasVoluntario = data.data);
        },
    
    }
}

</script>

<style scoped>

</style>