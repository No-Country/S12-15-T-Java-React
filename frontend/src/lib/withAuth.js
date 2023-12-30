'use client';
import { useState, useEffect } from 'react';
import { useRouter } from 'next/navigation';

const withAuth = (ProtectComponent) => {
    const Auth = (props) => {
        const [isAuthenticated, setIsAuthenticated] = useState(null);

        const router = useRouter();
        
        useEffect(() => {
            const storedUser = JSON.parse(localStorage.getItem('user'));
            setIsAuthenticated(storedUser);
            if (!storedUser) {
                router.replace('/login');
            } 
        }, [router]);

    return isAuthenticated ? <ProtectComponent {...props} /> : null;
  };

  return Auth;
};

export default withAuth;