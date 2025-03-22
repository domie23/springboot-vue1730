const base = {
    get() {
        return {
            url : "http://localhost:8080/haitongshouyang/",
            name: "haitongshouyang",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/haitongshouyang/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "孩童收养信息管理"
        } 
    }
}
export default base
