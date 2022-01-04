import Vue from 'vue'
import App from './App.vue'
import DataTable from 'primevue/datatable';
import Column from 'primevue/column';
import Card from 'primevue/card';
import Panel from 'primevue/panel';
import Menubar from 'primevue/menubar';
import Dialog from 'primevue/dialog';
import ToastService from 'primevue/toastservice';
import Toast from 'primevue/toast';

import 'primevue/resources/themes/saga-blue/theme.css';
import 'primevue/resources/primevue.min.css';
import 'primeicons/primeicons.css';

Vue.config.productionTip = false
Vue.component('Datatable', DataTable);
Vue.component('Column', Column);
Vue.component('Card', Card);
Vue.component('Panel', Panel);
Vue.component('Menubar', Menubar);
Vue.component('Dialog', Dialog);
Vue.component('ToastService', ToastService);
Vue.component('Toast', Toast);

new Vue({
  render: h => h(App),
}).$mount('#app')
