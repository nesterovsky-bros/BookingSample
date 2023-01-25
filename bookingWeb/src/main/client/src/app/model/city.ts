export interface City
{
    cityID: number;
    cityName: string;
    stateProvinceID: number;
    latestRecordedPopulation?: number;
    lastEditedBy: number;
    validFrom: Date|string;
    validTo: Date|string;
}