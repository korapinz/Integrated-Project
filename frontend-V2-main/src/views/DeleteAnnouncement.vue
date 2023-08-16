<script setup>
import {ref, onMounted } from 'vue';
import { useRoute ,useRouter } from 'vue-router'
const router = useRouter()
const { params } = useRoute()
const API_ROOT= import.meta.env.VITE_API_ROOT
const announcementDetail = ref([])

onMounted(async()=>{
 deleteAnnouncement()
})


const deleteAnnouncement = async () =>{
  const confirmed = window.confirm('Do you want to delete');
  if (confirmed) {
    try {
      const res = await fetch(`${API_ROOT}/api/announcements/${params.id}`,{
        method:'DELETE'
      })
      if(res.ok){
        announcementDetail.value = announcementDetail.value.filter((andata)=>andata.id !== params.id)
        console.log('delete successfully')
        router.push({
          name : 'home'
        })
      } else {
        alert(`There are no announcemnet id = ${params.id}`);
        router.push({
          name : 'home'
        })
        throw new Error('cannot delete data!')
      }
    } catch(error) {
      console.log(`ERROR: ${error}`)
      router.push({
        name : 'home'
      })
    }
  }else{
    router.push({
        name : 'home'
      })
  }
}
</script>
<template>
<div>

</div>
</template>
 
<style scoped>

</style>
 