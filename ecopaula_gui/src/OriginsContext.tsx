import { createContext, useContext, useState, useEffect, ReactNode } from 'react';
import axios from 'axios';

type Origin = {
    id: number;
    name_of_farm : string;
}

type OriginsContextType = {
    origins: Origin[];
    fetchOrigins: () => void;
};

const OriginsContext = createContext<OriginsContextType | undefined>(undefined);

export const OriginsProvider = ({ children} : {children: ReactNode }) => {
    const [origins, setOrigins] = useState<Origin[]>([]);

    const fetchOrigins = async () => {
        try {
            const response = await axios.get('http://localhost:8080/origins');
            setOrigins(response.data.map((origin: Origin) => ({
                id: origin.id,
                name_of_farm: origin.name_of_farm
            })));
        } catch (error) {
            console.error("Error fetching origins:", error);
        }
    };

    useEffect(() => {
        // Fetch origins when the provider mounts
        fetchOrigins();
    }, []);

    return (
        <OriginsContext.Provider value={{ origins, fetchOrigins }}>
            {children}
        </OriginsContext.Provider>
    );
};

export const useOrigins = () => {
    const context = useContext(OriginsContext);

    if (!context) {
        throw new Error('useOrigins must be used within an OriginsProvider')
    }
    return context;
}