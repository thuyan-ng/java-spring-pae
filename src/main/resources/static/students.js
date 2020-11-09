var req = new Vue({
    el: '#requestStudents',
    data: {
        selectedDisplay: null,
        students: []
    },
    methods: {
        getAllStudents: function () {
            let url = "http://localhost:8080/api/students";
            console.log("Appel à REST: " + url);

            axios.get(url).then((res) => {
                this.students = res.data;
            }).catch((error) => {
                console.log("Erreur : " + error);
            });
        }
    },
    mounted() {
        this.getAllStudents();
    }
});