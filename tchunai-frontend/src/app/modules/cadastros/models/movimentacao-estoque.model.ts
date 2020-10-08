import { ProdutoDominioModel } from '@shared/services/domain/cadastros/produto-domain.service';;

export class MovimentacaoEstoqueModel {
  id: number;
  notaFiscal: string;
  data: Date = new Date();
  tipoMovimentacao: string;
  origemMovimentacao: string;
  movimentacaoEstoqueDetalhes: MovimentacaoEstoqueDetalheModel[] = [];
}

export class MovimentacaoEstoqueDetalheModel {
  id: number;
  produto: ProdutoDominioModel;
  quantidade: number;
}
