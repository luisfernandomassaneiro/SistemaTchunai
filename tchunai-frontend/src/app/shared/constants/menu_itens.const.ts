
export const navItems = [ {
  text : 'Principal',
  i18n : 'menu.main',
  group : true,
  hideInBreadcrumb : true,
  children : [ {
    text : 'Home',
    i18n : 'menu.home',
    link : '/',
    icon : 'fas fa-home'
  }, {
    key : 'cadastros.cliente',
    text : 'Cliente',
    link : '/cadastros/cliente',
    i18n : 'menu.cadastros.cliente',
    icon: 'fas fa-users'
  }, {
    key : 'cadastros.produto',
    text : 'Produto',
    link : '/cadastros/produto',
    i18n : 'menu.cadastros.produto',
    icon: 'fas fa-paint-brush'
  }, {
    key : 'cadastros.movimentacaoestoque',
    text : 'MovimentacaoEstoque',
    link : '/cadastros/movimentacaoestoque',
    i18n : 'menu.cadastros.movimentacaoestoque',
    icon: 'fas fa-exchange-alt'
  }]
} ];
