module.exports = {
    outputDir: "../src/main/resources/static", // 빌드 타겟 디렉토리
    devServer: {
        proxy: {
            // '/api' 로 들어오면 포트 9000(스프링 서버)로 보낸다
            '/api': {
                target: 'http://localhost:9000',
            }
        }
    },
}