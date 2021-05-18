import { CategoriaDominioModel } from "@shared/services/domain/cadastros/categoria-domain.service";
import { CorDominioModel } from "@shared/services/domain/cadastros/cor-domain.service";
import { MarcaDominioModel } from "@shared/services/domain/cadastros/marca-domain.service";
import { TamanhoDominioModel } from "@shared/services/domain/cadastros/tamanho-domain.service";

export class ProdutoModel {
  id: number;
  descricao: string;
  precoCusto: number;
  precoVenda: number;
  percentualLucro: number;
  peso: string;
  active: boolean = true;
  quantidadeAtual: number;
  cor: CorDominioModel;
  tamanho: TamanhoDominioModel;
  categoria: CategoriaDominioModel;
  marca: MarcaDominioModel;
  codigoBarras: string;
}
