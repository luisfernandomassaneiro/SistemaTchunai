import { CategoriaDominioModel } from "@shared/services/domain/cadastros/categoria-domain.service";
import { ColecaoDominioModel } from "@shared/services/domain/cadastros/colecao-domain.service";
import { CorDominioModel } from "@shared/services/domain/cadastros/cor-domain.service";
import { MarcaDominioModel } from "@shared/services/domain/cadastros/marca-domain.service";
import { TamanhoDominioModel } from "@shared/services/domain/cadastros/tamanho-domain.service";

export class ProdutoFiltroModel {
    id: number;
    descricao: string;
    cor: CorDominioModel;
    tamanho: TamanhoDominioModel;
    categoria: CategoriaDominioModel;
    marca: MarcaDominioModel;
    codigoBarras: string;
    colecao: ColecaoDominioModel;
}
