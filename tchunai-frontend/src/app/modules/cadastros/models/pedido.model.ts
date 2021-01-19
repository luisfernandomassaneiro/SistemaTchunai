import { ClienteDominioModel } from '@shared/services/domain/cadastros/cliente-domain.service';
import { ProdutoDominioModel } from '@shared/services/domain/cadastros/produto-domain.service';

export class PedidoModel {
  id: number;
  data: Date;
  cliente: ClienteDominioModel;
  valorTotal: number;
  pedidoDetalhes: PedidoDetalheModel[] = [];
}

export class PedidoDetalheModel {
  id: number;
  produto: ProdutoDominioModel;
  quantidade: number;
}
