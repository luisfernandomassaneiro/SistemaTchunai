import { ClienteDominioModel } from '@shared/services/domain/cadastros/cliente-domain.service';;

export class PedidoResumoModel {
  id: number;
  data: Date;
  cliente: ClienteDominioModel;
  valorTotal: number;
}
