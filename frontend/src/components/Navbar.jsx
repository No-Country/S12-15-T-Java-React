import '@/styles/navbar.css';
import Link from 'next/link';

function Navbar() {
	return (
		<div className="nav-gral">
			<nav className="nav-container">
				<div className="track">
					<img src="/images/Logo.png" alt="Logo" />

					<h1 className="title">Track</h1>
				</div>
				<div className="dropdowns">
					<select className="proyectos">
						<option value="Proyectos">Proyectos</option>
						<option value="opcion1">Opción 1</option>
						<option value="opcion2">Opción 2</option>
						<option value="opcion3">Opción 3</option>
					</select>
					<select className="recientes">
						<option value="Recientes">Recientes</option>
						<option value="opcion1">Opción 1</option>
						<option value="opcion2">Opción 2</option>
						<option value="opcion3">Opción 3</option>
					</select>
					<div className="btn-crear">
						<Link href="Crear" className="crear">
							Crear
						</Link>
					</div>
				</div>

				<div className="logo-usuario">
					<img src="/images/Usuario.png" alt="" />
				</div>
			</nav>
		</div>
	);
}

export default Navbar;
{
	/* <div style={{width: '100%', height: '100%', paddingLeft: 48, paddingRight: 48, paddingTop: 16, paddingBottom: 16, background: '#1E1E1E', justifyContent: 'space-between', alignItems: 'center', display: 'inline-flex'}}>
    <div style={{justifyContent: 'flex-start', alignItems: 'center', gap: 56, display: 'flex'}}>
        <div style={{justifyContent: 'center', alignItems: 'center', gap: 16, display: 'flex'}}>
            <div style={{width: 31, height: 35, justifyContent: 'flex-start', alignItems: 'flex-start', gap: 10, display: 'flex'}}>
                <div style={{flex: '1 1 0', alignSelf: 'stretch', position: 'relative'}}>
                    <div style={{width: 31, height: 17.80, left: 0, top: 0, position: 'absolute', background: 'linear-gradient(90deg, #9BF9CF 0%, #3D69F3 100%)'}}></div>
                    <div style={{width: 31, height: 17.80, left: 0, top: 8.60, position: 'absolute', background: 'linear-gradient(90deg, #9BF9CF 0%, #3D69F3 100%)'}}></div>
                    <div style={{width: 31, height: 17.80, left: 0, top: 17.20, position: 'absolute', background: 'linear-gradient(90deg, #9BF9CF 0%, #3D69F3 100%)'}}></div>
                </div>
            </div>
            <div style={{textAlign: 'center', color: '#FAFBFC', fontSize: 32, fontFamily: 'Nunito', fontWeight: '700', wordWrap: 'break-word'}}>Track</div>
        </div>
        <div style={{justifyContent: 'flex-start', alignItems: 'center', gap: 32, display: 'flex'}}>
            <div style={{paddingLeft: 16, paddingRight: 16, paddingTop: 8, paddingBottom: 8, borderRadius: 4, justifyContent: 'center', alignItems: 'center', gap: 8, display: 'flex'}}>
                <div style={{color: '#FAFBFC', fontSize: 20, fontFamily: 'Roboto', fontWeight: '500', wordWrap: 'break-word'}}>Proyectos</div>
                <div style={{width: 16, height: 16, position: 'relative', borderRadius: 2, overflow: 'hidden'}}>
                    <div style={{width: 16, height: 10, left: 0, top: 3.50, position: 'absolute', background: '#FAFBFC', borderRadius: 1}}></div>
                </div>
            </div>
            <div style={{paddingLeft: 16, paddingRight: 16, paddingTop: 8, paddingBottom: 8, borderRadius: 4, justifyContent: 'center', alignItems: 'center', gap: 8, display: 'flex'}}>
                <div style={{color: '#FAFBFC', fontSize: 20, fontFamily: 'Roboto', fontWeight: '500', wordWrap: 'break-word'}}>Reciente</div>
                <div style={{width: 16, height: 16, position: 'relative', borderRadius: 2, overflow: 'hidden'}}>
                    <div style={{width: 16, height: 10, left: 0, top: 3.50, position: 'absolute', background: '#FAFBFC', borderRadius: 1}}></div>
                </div>
            </div>
            <div style={{paddingLeft: 16, paddingRight: 16, paddingTop: 8, paddingBottom: 8, borderRadius: 4, justifyContent: 'center', alignItems: 'center', gap: 8, display: 'flex'}}>
                <div style={{color: '#FAFBFC', fontSize: 20, fontFamily: 'Roboto', fontWeight: '500', wordWrap: 'break-word'}}>Crear</div>
            </div>
        </div>
    </div>
    <img style={{width: 32, height: 32, background: 'linear-gradient(0deg, #D9D9D9 0%, #D9D9D9 100%)', borderRadius: 9999, border: '2px #FAFBFC solid'}} src="https://via.placeholder.com/32x32" />
</div> */
}
