import styles from '@/styles/createworkspace.module.css';
import InputImg from '@/components/create/InputImg';
import BtnTrash from './BtnTrash';

const FormInputGroup = ({ ...props }) => {
	return (
		<fieldset className={styles.container_form_group}>
			<div className={styles.container_input_content}>
				<label htmlFor="nameproyect">Nombre del proyecto:</label>
				<input
					type="text"
					id="nameproyect"
					name="nameproyect"
					value={props.proyectName}
					onChange={(e) => props.setProyectName(e.target.value)}
					placeholder="Nombre del proyecto"
				/>
			</div>
			<div className={styles.container_input_content}>
				<label htmlFor="description">Descripción:</label>
				<textarea
					placeholder="Descripción"
					id="description"
					name="description"
					value={props.description}
					onChange={(e) => props.setDescription(e.target.value)}
				></textarea>
			</div>
			<div className={styles.container_input_content}>
				<InputImg />
				<BtnTrash />
			</div>
		</fieldset>
	);
};

export default FormInputGroup;
