export type OptionalParam = null|undefined|string|number|boolean|Date|
    (null|undefined|string|number|boolean|Date)[];
export type Param = string|number|boolean|(string|number|boolean)[];

export type OptionalParams = { [param: string]: OptionalParam; }
export type Params = {[param: string]: Param }

export function params(params: OptionalParams): Params
{
    for(const key of Object.keys(params))
    {
        const value = params[key];

        if (value == null)
        {
            delete params[key];
        }
        else if (value instanceof Date)
        {
            params[key] = value.toJSON();
        }
        else if (Array.isArray(value))
        {
            params[key] = value.
            filter(item => item != null).
            map(item => item instanceof Date ? item.toJSON() : item);
        }
        // No more cases.
    }

    return params as Params;
}
