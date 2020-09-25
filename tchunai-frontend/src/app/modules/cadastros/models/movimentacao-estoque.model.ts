import { ProdutoDominioModel } from '@shared/services/domain/cadastros/produto-domain.service';;

export class MovimentacaoEstoqueModel {
  id: number;
  nome: string;
  produto: ProdutoDominioModel;
  tipoMovimentacao: string;
  origemMovimentacao: string;
}
