<script setup>
    import UserTable from './UserTable.vue';
    import {useRouter} from 'vue-router'
import LoginFetch from './LoginFetch.vue';
import UserRegister from '../components/UserRegister.vue';
import RegisterFetch from './RegisterFetch.vue';
import NavBar from './NavBar.vue';
    
   
    </script>
     
    <template>
       <NavBar />
        <div>
            <RegisterFetch/>
            
        </div>
            
    </template>
     
    <style>
    
    </style>