import { Injectable } from '@angular/core';

import { NzIconService } from 'ng-zorro-antd';
import { ICONS_AUTO } from '../../../style-icons-auto';
import { ICONS } from '../../../style-icons';
import { SystemSettingsService } from '@shared/services/system-settings.service';

const path = "M165.327 59.689 C 116.483 108.754,113.990 112.771,113.990 142.385 C 113.990 153.016,114.819 163.334,115.832 " +
             "165.313 C 116.846 167.292,119.411 172.642,121.532 177.202 C 125.252 185.198,201.732 265.285,205.648 265.285 C " +
             "208.712 265.285,213.472 251.394,213.472 242.451 C 213.472 229.945,209.831 224.626,181.891 196.318 C 131.330 " +
             "145.089,131.291 138.883,181.208 89.288 C 210.540 60.146,214.344 54.069,213.047 38.429 C 211.011 13.885,210.854 " +
             "13.955,165.327 59.689 M202.051 127.785 C 199.314 131.962,198.235 137.319,198.319 146.306 C 198.459 161.216,197.188 " +
             "159.432,234.818 197.506 C 252.714 215.613,261.737 226.301,262.547 230.351 C 263.207 233.654,264.560 236.858,265.553 " +
             "237.471 C 268.069 239.026,267.825 254.922,265.285 254.922 C 264.145 254.922,263.212 257.318,263.212 260.246 C 263.212 " +
             "264.318,255.738 273.219,231.441 298.084 C 194.810 335.571,189.828 347.160,202.893 364.481 L 206.410 369.144 244.130 " +
             "331.693 C 297.635 278.570,307.022 258.759,295.238 223.834 C 289.438 206.643,285.538 201.761,245.633 161.749 L 205.901 " +
             "121.909 202.051 127.785 ";
const seniorLogo = `<svg id="svg" xmlns="http://www.w3.org/2000/svg"  width="400" height="400" viewBox="0, 0, 400,400">
                        <g id="svgg"><path id="path0" d="${path}" stroke="none" fill="#048464" fill-rule="evenodd"></path></g>
                    </svg>`;
const seniorIcon = `<svg id="svg" xmlns="http://www.w3.org/2000/svg"  width="400" height="400" viewBox="0, 0, 400,400">
                        <g id="svgg"><path id="path0" d="${path}" stroke="none" fill="#fff" fill-rule="evenodd"></path></g>
                    </svg>`;

@Injectable()
export class AppStartupService {
  constructor(
    iconSrv: NzIconService,
    private readonly systemSettingsService: SystemSettingsService,
  ) {
    iconSrv.addIcon(...ICONS_AUTO, ...ICONS);
    iconSrv.addIconLiteral('senior:icon', seniorIcon);
    iconSrv.addIconLiteral('senior:logo', seniorLogo);
  }

  private viaHttp(resolve: any) {
    this.systemSettingsService.load().then(() => {
      document.getElementsByTagName('title')[0].innerHTML = this.systemSettingsService.settings.appName;
    }).finally(() => {
      resolve(null);
    });
  }

  init(): Promise<any> {
    return new Promise((resolve) => {
      this.viaHttp(resolve);
    });
  }
}

export function AppProviderFactory(provider: AppStartupService) {
  return () => provider.init();
}
