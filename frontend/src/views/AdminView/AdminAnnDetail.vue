<script setup>
import {ref, onMounted } from 'vue';
import { useRoute ,useRouter } from 'vue-router'
import { formatDate } from '../../composable/formatDate'
const router = useRouter()
const { params } = useRoute()
const API_ROOT = import.meta.env.VITE_API_ROOT
const announcementDetail = ref([])
const errorMSG = ref('')
onMounted(()=>{
    loadDetail()
})

const loadDetail = async () =>{
    try {
        const res = await fetch(`${API_ROOT}/api/announcements/${params.id}`)
        if(!res.ok){
            alert('The request page is not available')
            router.push({
                name : 'home'
            })
            throw new Error(res.status)
        }else{
            announcementDetail.value = await res.json()
        }
    }catch(err){
        errorMSG.value = err
    }
}

const editAnnouncement = (announcementId) =>{
    router.push({
        name : 'updateAnnounce',
        params : {id : announcementId}
    })
}

</script>

<template>
     <div class="p-4 sm:ml-64" style="background-color: #83a8f3;">
        <h1 class="ml-10 font-bold text-2xl mb-1.5" style="line-height: 2.5;">Announcement Detail :</h1>
        <div class="container">
            <div class="announcement">
                <img src="../assets/images/jett.png" alt="Girl in a jacket" width="200" height="200">
                <h1 class="text-lg font-bold">You can edit your data. Just click at EDIT button!</h1>
                <button @click="editAnnouncement(announcementDetail.id)" class="ann-button ml-10 mb-6 btn border border-blue-600 bg-blue-700">Edit</button>
            </div>
        </div>
        <div class=" ml-10 mr-10 mb-10 border-black border-2 p-10 rounded-lg" style=" background-color: #ffffff;line-height:50px " >
            <table class="ann-item">
                <tr >
                    <td><span class="font-bold ">Title  </span></td>
                    <td class="ann-title pl-10" >{{ announcementDetail.announcementTitle}}</td>
                </tr>
                <tr >
                    <td><span class="font-bold ">Category </span></td>
                    <td class="ann-category pl-10" >{{ announcementDetail.announcementCategory }}</td>
                </tr>
                <tr>
                    <td><span class="font-bold ">Description </span></td>
                    <td class="ann-description pl-10" >{{ announcementDetail.announcementDescription }}</td>
                </tr>
                <tr >
                    <td><span class="font-bold ">Publish Date </span></td>
                    <td class="ann-publish-date pl-10" >{{ announcementDetail.publishDate === null || announcementDetail.publishDate === undefined ? '-' :  formatDate(announcementDetail.publishDate)}}</td>
                </tr>
                <tr >
                    <td><span class="font-bold ">Close Date </span></td>
                    <td class="ann-close-date pl-10" >{{ announcementDetail.closeDate === null || announcementDetail.closeDate === undefined ? '-' : formatDate(announcementDetail.closeDate) }}</td>
                </tr>
                <tr >
                    <td><span class=" font-bold ">Display </span></td>
                    <td class="ann-display pl-10" >{{ announcementDetail.announcementDisplay}}</td>
                </tr>
                
            </table>
           
        </div >
        
        <router-link to="/admin/announcement"><button class="ann-button ml-10 btn bg-gray-500 border border-gray-500 mb-5">Back</button></router-link>
</div>
</template>
<style>
.container {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  margin: 0 auto;
  max-width: 800px;
  padding: 20px;
  margin-left: 20px;
}

.title {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 10px;
}

.announcement {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 50%;
  padding: 20px;
  background-color: #eee;
  border-radius: 10px;
  margin-bottom: 20px;
}

.announcement img {
  margin-right: 20px;
}

.edit-btn {
  background-color: #007aff;
  color: #fff;
  border: none;
  border-radius: 5px;
  padding: 10px 20px;
  cursor: pointer;
  font-size: 16px;
}
</style>
