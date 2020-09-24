
export const navItems = [ {
  text : 'Principal',
  i18n : 'menu.main',
  group : true,
  hideInBreadcrumb : true,
  children : [ {
    text : 'Home',
    i18n : 'menu.home',
    link : '/',
    icon : 'fasfa-home'
  }, {
    key : 'cadastros',
    text : 'Cadastros',
    i18n : 'menu.cadastros',
    icon : 'anticonanticon-senior:icon',
    children : [ {
      key : 'cadastros.cliente',
      text : 'Cliente',
      link : '/cadastros/cliente',
      i18n : 'menu.cadastros.cliente'
    }, {
      key : 'cadastros.produto',
      text : 'Produto',
      link : '/cadastros/produto',
      i18n : 'menu.cadastros.produto'
    } ]
  } ]
} ];
