
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
    icon : 'fas fa-users'
  }, {
    key : 'cadastros.produto',
    text : 'Produto',
    link : '/cadastros/produto',
    i18n : 'menu.cadastros.produto',
    icon : 'fas fa-tshirt'
  }, {
    key : 'cadastros.movimentacaoestoque',
    text : 'MovimentacaoEstoque',
    link : '/cadastros/movimentacaoestoque',
    i18n : 'menu.cadastros.movimentacaoestoque',
    icon : 'fas fa-exchange-alt'
  }, {
    key : 'cadastros.pedido',
    text : 'NovoPedido',
    link : '/cadastros/pedido',
    i18n : 'menu.cadastros.pedido',
    icon : 'anticonanticon-file'
  }, {
    key : 'cadastros.pedido',
    text : 'Pedido',
    link : '/cadastros/pedido/incluir',
    i18n : 'menu.cadastros.pedido',
    icon : 'anticonanticon-file-add'
  }, {
    key : 'cadastros',
    text : 'Cadastros',
    i18n : 'menu.cadastros',
    icon : 'fas fa-plus-circle',
    children : [ {
      key : 'cadastros.categoria',
      text : 'Categoria',
      link : '/cadastros/categoria',
      i18n : 'menu.cadastros.categoria'
    }, {
      key : 'cadastros.colecao',
      text : 'Colecao',
      link : '/cadastros/colecao',
      i18n : 'menu.cadastros.colecao'
    }, {
      key : 'cadastros.cor',
      text : 'Cor',
      link : '/cadastros/cor',
      i18n : 'menu.cadastros.cor'
    }, {
      key : 'cadastros.marca',
      text : 'Marca',
      link : '/cadastros/marca',
      i18n : 'menu.cadastros.marca'
    }, {
      key : 'cadastros.tamanho',
      text : 'Tamanho',
      link : '/cadastros/tamanho',
      i18n : 'menu.cadastros.tamanho'
    } ]
  } ]
} ];
