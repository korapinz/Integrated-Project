const API_ROOT= import.meta.env.VITE_API_ROOT

const getCategories = async () => {
    try {
        const res = await fetch(API_ROOT+"/api/categories")
        // if(res.status===201)        
        if (res.ok) {
            const categories = res.json()
            return categories       
        } 
            else throw new error('Error, cannot get data!')
    } catch (error) {
        console.log(error)
    }
}
export { getCategories }