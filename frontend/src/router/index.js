import { createRouter, createWebHistory } from 'vue-router'
import AdminAnnView from '../views/AdminView/AdminAnnView.vue'
import AdminAnnDetail from '../views/AdminView/AdminAnnDetail.vue'
import CreateAnnouncement from '../views/CreateAnnouncement.vue'
import DeleteAnnouncement from '../views/DeleteAnnouncement.vue'
import UpdateAnnouncement from '../views/UpdateAnnouncement.vue'
import UserAnnView from '../views/UserView/UserAnnView.vue'
import UserAnnDetail from '../views/UserView/UserAnnDetail.vue'
import AdminUserView from '../views/AdminView/AdminUserView.vue'
import AddUserView from '../views/AdminView/AddUserView.vue'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/admin/announcement',
      name: 'home',
      component: AdminAnnView
    },
    {
      path: '/admin/announcement/:id',
      name: 'desc',
      component: AdminAnnDetail
    },
    {
      path: '/admin/announcement/add',
      name: 'addAnnounce',
      component: CreateAnnouncement
    },
    {
      path: '/admin/announcement/:id/delete',
      name: 'deleteAnnounce',
      component: DeleteAnnouncement
    },
    {
      path: '/admin/announcement/:id/edit',
      name: 'updateAnnounce',
      component: UpdateAnnouncement
    },
    {
      path: '/announcement',
      name: 'UserAnnView',
      component: UserAnnView
    },
    {
      path: '/announcement/:id',
      name: 'UserAnnDetail',
      component: UserAnnDetail
    },
    {
      path: '/admin/user',
      name: 'AdminUserView',
      component: AdminUserView
    },
    {
      path: '/admin/user/add',
      name: 'AddUserView',
      component: AddUserView
    }
  ]
})

export default router
