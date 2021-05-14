module.exports = {
  transpileDependencies: [
    'vuetify'
  ]
}

const path = require('path');
module.exports = {
  outputDir: path.resolve(__dirname, '../src/main/resources/static/'),
  devServer: {
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        ws: true,
        pathRewrite: { '^/api': '/'},
        changeOrigin: true,
      },
    },
  },
};