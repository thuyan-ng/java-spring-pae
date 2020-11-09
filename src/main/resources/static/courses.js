var req = new Vue({
    el: '#requestCourses',
    data: {
        selectedDisplay: null,
        courses: []
    },
    methods: {
        getAllCourses: function () {
            let url = "http://localhost:8080/api/courses";
            console.log("Appel à REST: " + url);

            axios.get(url).then((res) => {
                this.courses = res.data;
            }).catch((error) => {
                console.log("Erreur : " + error);
            });
        }
    },
    beforeMount: function () {
        this.selectedDisplay = this.courses[0];
    },
    mounted() {
        this.getAllCourses();
    }
});

